package com.jackyshen.enums;

public class RabbitEnum extends CommonEnum {

  public enum Exchange {
    KEYWORDSEARCH("topic.keywordsearch"), 
    DOCVIEW("topic.docView"), 
    EMAIL("topic.email"), 
    DMSOTHER("topic.dmsOther"), 
    COMPANYTRIAL("topic.companyTrial");

    String name;

    Exchange(String name) {
      this.name = name;
    }

    public String toString() {
      return this.name;
    }
  }

  public enum Queue {
    INSERT("insert"), 
    INSERTBULK("insertBulk"), 
    UPDATE("update"), 
    UPDATEBULK("updateBulk"), 
    UPDATECONTENT("updateContent"), 
    DOCVIEW("docView"), 
    IMMEDIATELYDOCVIEW("immediatelyDocView"), 
    EMAIL("email"), 
    MD5("md5"), 
    VIRUS("virus"), 
    COMPANYTRIAL("companyTrial");
    
    String name;

    Queue(String name) {
      this.name = name;
    }

    public String toString() {
      return this.name;
    }
  }
}
