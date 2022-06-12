package com.algonquin.loggy.beans;

import java.util.Date;
import java.util.UUID;

public abstract class Log {
    private UUID id;
    private String title;
    private String content;
    private Date createTimestamp;
}
