package org.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class SimpleResponse<T> {
    private final T result;
}
