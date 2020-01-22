package edu.forty.bits.datastructures.bitops;

import edu.forty.bits.datastructures.annotations.BitOps;

/**
 * Explain what the following code does ((n & (n-1)) ==0)
 */
@BitOps
public class Debugger {
    // there is only a bit change possible between n and n-1
    // the chances of n & n-1 to become 0 is only when the most significant bit has changed e.g. 0111 and 1000
}