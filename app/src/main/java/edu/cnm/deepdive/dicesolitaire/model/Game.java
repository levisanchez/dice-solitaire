package edu.cnm.deepdive.dicesolitaire.model;

import java.util.Random;

public class Game {

  public static final int SET_SIZE = 2;
  public static final int NUM_SETS = 2;
  public static final int NUM_SCRACHES = 1;
  public static final int NUM_DICE = NUM_SCRACHES + NUM_SETS * SET_SIZE;
  public static final int NUM_FACES = 6;
  public static final int MIN_SET_VALUE = SET_SIZE;
  public static final int MAX_SET_VALUE = SET_SIZE * NUM_FACES;
  public static final int MAX_SET_COUNT = 10;
  public static final int MAX_SCRATCH_COUNT = 8;

  private final Random rng;
  private int[] setCounts = new int[MAX_SET_VALUE - MIN_SET_VALUE + 1];
  private int[] scratchCounts = new int[NUM_FACES];


  public Game(Random rng) {
    this.rng = rng;
  }

  public boolean incrementSetCount(int setValue) {
    int count = setCounts[setValue - MIN_SET_VALUE];
    if (count < MAX_SET_COUNT) {
      count++;
      setCounts[setValue - MIN_SET_VALUE] = count;
      return true;
    } else {
      return false;
    }
    setCounts[setValue - MIN_SET_VALUE]++;
  }

  public boolean incrementScratchCount(int scratchValue) {
    int count = scratchCounts[scratchValue - 1];
    if (count < MAX_SCRATCH_COUNT) {
      count++;
      setCounts[scratchValue - MIN_SET_VALUE] = count;
      return true;
    } else {
      return false;
    }
  }


}