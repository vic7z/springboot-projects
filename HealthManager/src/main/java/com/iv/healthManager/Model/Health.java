package com.iv.healthManager.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Health {
    private int HeartRate;
    private float Temperature;
}
