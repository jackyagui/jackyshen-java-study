package com.jackyshen.enums;

import com.jackyshen.Utility;

public class CommonEnum {
  public enum YesNoFlag {
    YES("Y"), NO("N");

    private String name;

    YesNoFlag(String name) {
      this.name = name;
    }

    public String toString() {
      return this.name;
    }

    public static YesNoFlag valueOf(int ordinal) {
      return YesNoFlag.values()[ordinal];
    }

    public static YesNoFlag fromAcronym(String acronym) {
      if (Utility.isEmpty(acronym)) {
        return YesNoFlag.YES;
      }
      for (YesNoFlag flag : YesNoFlag.values()) {
        if (acronym.equals(flag.toString())) {
          return flag;
        }
      }
      return YesNoFlag.YES;
    }
  }
}
