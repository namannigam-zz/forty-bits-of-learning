package edu.forty.bits.ps.competitive.browserstack;

import java.util.*;

public class LogParser {

    /**
     * Started <REQUEST_TYPE> <RELATIVE_URL> for <IP> at <REQUEST_TIMESTAMP> Processing by
     * <CONTROLLER>#<ACTION> as <REQUEST_FORMAT> Parameters: <Key Value pair for each parameters>
     * <LOG_LINE_1> <LOG_LINE_2> ...... <LOG_LINE_N>
     *
     * <p>Rendered <SOME_TEMPLATE_0> (<TIMETAKEN_0>) Rendered <SOME_TEMPLATE_1> (<TIMETAKEN_1>) ...
     * ... Rendered <SOME_TEMPLATE_N> (<TIMETAKEN_N>)
     *
     * <p>Completed <RESPONSE_CODE> in <OVERALL_TIME_TAKEN> (Views: <TIME_VIEWS> | ActiveRecord:
     * <TIME_ACTIVE_RECORD> | Sphinx: <TIME_SPHINX>)
     */
    private static final String SEPARATOR = "***************###############***************";

    private static final Integer QUERY_ATTR = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> logs = new ArrayList<>();
        while (!scanner.next().equals(SEPARATOR)) {
            logs.add(scanner.next());
        }
        System.out.println(logs);

        Map<Integer, Filters> logIdToFiltersMap = new HashMap<>();
        for (String log : logs) {
            Filters filters = new Filters();

            // Find and set the REQUEST_TYPE
            int startIndex = log.indexOf("Started");
            String requestType = log.substring(startIndex, log.indexOf(" ", startIndex)).trim();
            filters.setRequestType(Filters.RequestType.valueOf(requestType));

            // Get the RELATIVE_URL
            String relativeUrl = log.substring(log.indexOf(requestType), log.indexOf(" for ")).trim();
            filters.setRelativeUrl(relativeUrl);

            // Get the IP
            String ip =
                    log.substring(log.indexOf(" for "), log.indexOf(" ", log.indexOf(" for "))).trim();
            filters.setIp(ip);

            // Get the RequestFormat
            String requestFormat;
            if (!log.contains(" as ")) {
                requestFormat = "HTML";
            } else {
                requestFormat =
                        log.substring(log.indexOf(" as "), log.indexOf(" ", log.indexOf(" as "))).trim();
            }
            filters.setRequestFormat(Filters.RequestFormat.valueOf(requestFormat));

            // Get the status code
            String status =
                    log.substring(log.indexOf(" Completed "), log.indexOf(" ", log.indexOf(" Completed ")))
                            .trim();
            filters.setStatusCode(status);

            // collect into a map with logId and its corresponding filters
            logIdToFiltersMap.put(logs.indexOf(log), filters);
        }

        scanner.next(); // ignore separator

        // Process the query for finding the count. This is currently bound to a constant of query types
        for (int i = 0; i < QUERY_ATTR; i++) {
            String query = scanner.next();
            System.out.println(countFilteredLogs(i, query, new ArrayList<>(logIdToFiltersMap.values())));
        }
    }

    /**
     * Method to count the complete logs to be filtered for a given query and type of query and filter
     * values
     */
    private static long countFilteredLogs(int i, String query, List<Filters> filters) {
        switch (i) {
            case 0:
                return filters.stream().filter(f -> f.getRequestType().toString().equals(query)).count();
            case 1:
                return filters.stream().filter(f -> f.getRelativeUrl().equals(query)).count();
            case 2:
                return filters.stream().filter(f -> f.getIp().equals(query)).count();
            case 3:
                return filters.stream().filter(f -> f.getRequestFormat().toString().equals(query)).count();
            case 4:
                return filters.stream().filter(f -> f.getStatusCode().equals(query)).count();
            default:
                System.out.println("Should never be reached!");
                return 0;
        }
    }

    static class Filters {
        RequestType requestType;
        String relativeUrl;
        String ip;
        RequestFormat requestFormat;
        String statusCode;

        RequestType getRequestType() {
            return requestType;
        }

        void setRequestType(RequestType requestType) {
            this.requestType = requestType;
        }

        String getRelativeUrl() {
            return relativeUrl;
        }

        void setRelativeUrl(String relativeUrl) {
            this.relativeUrl = relativeUrl;
        }

        String getIp() {
            return ip;
        }

        void setIp(String ip) {
            this.ip = ip;
        }

        RequestFormat getRequestFormat() {
            return requestFormat;
        }

        void setRequestFormat(RequestFormat requestFormat) {
            this.requestFormat = requestFormat;
        }

        String getStatusCode() {
            return statusCode;
        }

        void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        enum RequestFormat {
            JSON,
            HTML,
            JS
        }

        enum RequestType {
            GET,
            PUT,
            POST,
            DELETE
        }
    }
}
