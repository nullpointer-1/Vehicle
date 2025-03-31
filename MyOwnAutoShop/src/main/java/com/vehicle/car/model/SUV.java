package com.vehicle.car.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "suvs")
@PrimaryKeyJoinColumn(name = "car_id")
public class SUV extends Car {
private int weight;
private boolean hasThirdRowSeat;
private boolean is4wd;



// public SUV(int weight, boolean hasThirdRowSeat, boolean is4wd) {
//     this.weight = weight;
//     this.hasThirdRowSeat = hasThirdRowSeat;
//     this.is4wd = is4wd;
// }

public int getWeight() {
    return weight;
}

public void setWeight(int weight) {
    this.weight = weight;
}

public boolean isHasThirdRowSeat() {
    return hasThirdRowSeat;
}

public void setHasThirdRowSeat(boolean hasThirdRowSeat) {
    this.hasThirdRowSeat = hasThirdRowSeat;
}

public boolean isIs4wd() {
    return is4wd;
}

public void setIs4wd(boolean is4wd) {
    this.is4wd = is4wd;
}

@Override
public double getSalePrice() {
double discount = (weight > 2000) ? 0.10 : 0.20;
return getRegularPrice() * (1 - discount);
}

@Override
public String getDescription() {
return super.getDescription() + String.format(", %d kg, %s",
weight, is4wd ? "4WD" : "2WD");
}
}