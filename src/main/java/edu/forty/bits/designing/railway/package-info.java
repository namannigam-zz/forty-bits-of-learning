package edu.forty.bits.designing.railway;

/*
 * Train route from one station to another can vary based on the type of the train and passenger requirements.
 * Design a railway system that could help with:
 *  - Building on a system that keeps a track of all such possible routes from one station to another.
 * Weights on these routes could vary based on the speed of the train (dynamic) and the distance between
 * two stations(node).
 * - Introducing a new train from one destination to another, determine what should be its possible type. The type
 * could vary based on the speed it should travel with on that route.
 * ::Note a factor of congestion would also play a role to determine the possibility of such new introduction.
 * - There could always be a possibility for a new station is introduced for
 * certain types of trains to stop at that station.
 * - The information passed for a given train shall include its complete route. Which would include,
 * the time taken by it from one station to another, distance between each station and wait time on station.
 *
 *
 * Important:: Would it be possible to extend the solution to find similar trains on the same route?
 * What if someone wants to know about a connecting train possible to catch from one station to another when
 * a route is not possible between the source and destination.
 */