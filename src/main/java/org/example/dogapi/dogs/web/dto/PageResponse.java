package org.example.dogapi.dogs.web.dto;

import java.util.List;

public record PageResponse<T>(

        List<T> items,
        PageMeta meta
) {
}