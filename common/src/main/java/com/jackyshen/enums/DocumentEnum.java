package com.jackyshen.enums;

import com.jackyshen.Utility;

public class DocumentEnum extends CommonEnum {

  public enum DocViewStatus {
    PENDING("P"), UNSUPPORT("U"), INACTIVE("I"), ERROR("E"), COMPLETE("C"), RUNNING("R");

    private String name;

    DocViewStatus(String name) {
      this.name = name;
    }

    public String toString() {
      return this.name;
    }

    public static DocViewStatus valueOf(int ordinal) {
      return DocViewStatus.values()[ordinal];
    }

    public static DocViewStatus fromAcronym(String acronym) {
      if (Utility.isEmpty(acronym)) {
        return null;
      }
      for (DocViewStatus status : DocViewStatus.values()) {
        if (acronym.equals(status.toString())) {
          return status;
        }
      }
      return null;
    }
  }
}
