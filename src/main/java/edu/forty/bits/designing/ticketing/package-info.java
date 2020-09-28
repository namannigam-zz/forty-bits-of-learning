package edu.forty.bits.designing.ticketing;

/*
 * You are given to design a ticket generation system. The system is supposedly integrated with intelligence
 * around learning to improve based upon the ticket resolutions over a period of time.
 * The tickets assigned can include comments from the team it was assigned to and can be reassigned to another team.
 * Every team has an escalation SLA (S) defined as a duration in which they must respond before
 * the ticket gets reassigned to their parent team. The escalation then applies to the parent team as well.
 * The tickets assigned have their own ttl (threshold - T) attached to them, which means that if a ticket is
 * not resolved within that duration, by the organisation of teams, its deemed to be resolved as Expired.
 */