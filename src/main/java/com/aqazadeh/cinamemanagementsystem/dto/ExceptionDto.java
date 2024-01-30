package com.aqazadeh.cinamemanagementsystem.dto;

import java.time.LocalDateTime;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date:30.01.2024
 * Time:21:12
 */

public record ExceptionDto(
        String message,
        LocalDateTime time
) {
}
