package org.ylgjj.loan.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.time.FastDateFormat;


import java.util.Date;

public class DateRange implements Comparable<DateRange> {
    public static FastDateFormat getFORMAT() {
        return FORMAT;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    private static final FastDateFormat FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss.SSS");
 
    private final long start;
 
    private final long end;
 
    public DateRange(long start, long end) {
     //   checkArgument(start >= 0, "start must be a positive number");
        if (end < start) {
            throw new IllegalArgumentException(String.format("start (%d) must come before end (%d)", start, end));
        }
        this.start = start;
        this.end = end;
    }
 
    public long start() {
        return start;
    }
 
    public long end() {
        return end;
    }
 
  //  @JsonIgnore
    public boolean isEmpty() {
        return diff() == 0;
    }
 
  //  @JsonIgnore
    public boolean isNotEmpty() {
        return !isEmpty();
    }
 
    public long diff() {
        return end - start;
    }
 
    public DateRange rounded(long interval) {
        if (interval <= 0) {
            return this;
        }
        return new DateRange(start - start % interval, end - (end % interval));
    }
 
    public boolean overlap(DateRange other) {
        if (end < other.start) {
            return false;
        }
        if (start > other.end) {
            return false;
        }
        return true;
    }
 
    @Override
    public int compareTo(DateRange other) {
        return Long.compare(start, other.start);
    }
 
    public DateRange join(DateRange other) {
        long start = Math.min(this.start, other.start);
        long end = Math.max(this.end, other.end);
        return new DateRange(start, end);
    }
 
    public boolean contains(long t) {
        return t >= start && t <= end;
    }
 
    public DateRange modify(DateRange range) {
        return modify(range.getStart(), range.getEnd());
    }
 
    public DateRange modify(long start, long end) {
        return new DateRange(Math.max(this.start, start), Math.min(this.end, end - 1));
    }
 
    public DateRange start(long start) {
        return new DateRange(start, this.end);
    }
 
    public DateRange end(long end) {
        return new DateRange(this.start, end);
    }
 
    public DateRange shift(long extent) {
        return new DateRange(Math.max(start + extent, 0), Math.max(end + extent, 0));
    }
 
    @Override
    public String toString() {
        final Date start = new Date(this.start);
        final Date end = new Date(this.end);
        return "{" + FORMAT.format(start) + "}-{" + FORMAT.format(end) + "}";
    }
 
  //  @JsonCreator
    public static DateRange create(@JsonProperty(value = "start", required = true) Long start, @JsonProperty(value = "end", required = true) Long end) {
        return new DateRange(start, end);
    }
 
    public static DateRange now(long now) {
        return new DateRange(now, now);
    }
 
   // public static DateRange now(Clock clock) {
     //   return now(clock.currentTimeMillis());
  //  }
 
/*    public void hashTo(final ObjectHasher hasher) {
        hasher.putObject(getClass(), () -> {
            hasher.putField("start", start, hasher.longValue());
            hasher.putField("end", end, hasher.longValue());
        });
    }*/
}
/*
————————————————
版权声明：本文为CSDN博主「笑着飘走」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_29466963/article/details/95349292*/
