package com.example.cocomo;

enum TYPES {
    RELY("RELY"),
    DATA("Data"),
    CPLX("CPLX"),
    TIME("TIME"),
    STOR("STOR"),
    VIRT("VIRT"),
    TURN("TURN"),
    ACAP("ACAP"),
    AEXP("AEXP"),
    PCAP("PCAP"),
    VEXP("VEXP"),
    LEXP("LEXP"),
    MODP("MODP"),
    TOOL("TOOL"),
    SCED_POST("SCED_POST"),
    PREC("PREC"),
    FLEX("FLEX"),
    RESL("RESL"),
    TEAM("TEAM"),
    PMAT("PMAT"),
    PERS("PERS"),
    PREX("PREX"),
    RCPX("RCPX"),
    RUSE_POST("RUSE_POST"),
    PDIF("PDIF"),
    FCIL("FCIL"),
    PCON("PCON"),
    PEXP("PEXP"),
    LTEX("LTEX"),
    DOCU("DOCU"),
    PVOL("PVOL"),
    SITE("SITE"),
    RUSE_EARLY("RUSE_EARLY"),
    SCED_EARLY("SCED_EARLY"),
    SCED("SCED"),
    RUSE("RUSE");

    final String type;

    TYPES(String type) {
        this.type = type;
    }
}
