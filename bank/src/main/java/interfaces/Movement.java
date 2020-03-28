package models;

import java.time.LocalDateTime;

public interface Movement {
    LocalDateTime getTime();
    long getAmount();
}
