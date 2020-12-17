package com.iv.healthManager.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class labReport {
    private float bp;
    private float bloodsugar;
    private List<String> value;

    public labReport() {
        this.value = new ArrayList<>();
    }
}
