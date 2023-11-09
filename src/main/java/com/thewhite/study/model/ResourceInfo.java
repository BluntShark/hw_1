package com.thewhite.study.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResourceInfo {
    private int id;
    private String name;
    private String description;
    private String link;
}
