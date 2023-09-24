package tdd.uppgift.grupp;

public class Car {
  private boolean hasLights;
  private boolean hasHighBeam;
  private boolean hasLowBeam;
  private boolean hasTailLights;
  private boolean isRunning;
  private boolean hazardLightsOn;
  private int gasState; // Accelerate = 1, Brake = -1, Release gas and brake = 0
  private int currentSpeed;
  private String gear;
  private boolean brakeLightOn;
  private int batteryLevel;

  public Car() {
    this.isRunning = false;
    this.hasLights = false;
    this.hasHighBeam = false;
    this.hasLowBeam = false;
    this.hasTailLights = false;
    this.hazardLightsOn = false;
    this.gasState = 0;
    this.currentSpeed = 0;
    this.gear = "drive";
    this.brakeLightOn = false;
    this.batteryLevel = 100;
  }


  //GETTERS
  public boolean hasLights() {
    return hasLights;
  }

  public boolean hasHighBeam() {
    return hasHighBeam;
  }

  public boolean hasLowBeam() {
    return hasLowBeam;
  }

  public boolean hasTailLights() {
    return hasTailLights;
  }

  public boolean isRunning() {
    return isRunning;
  }

  public boolean areHazardLightsOn() {
    return hazardLightsOn;
  }

  public boolean isAccelerating() {
    return gasState == 1;
  }

  public boolean isBraking() {
    return gasState == -1;
  }

  public boolean isNeitherAcceleratingNorBraking() {
    return gasState == 0;
  }

  public int getCurrentSpeed() {
    return currentSpeed;
  }

  public String getGear() {
    return gear;
  }

  public boolean isBrakeLightOn() {
    return brakeLightOn;
  }

  public int getBatteryLevel() {
    return batteryLevel;
  }


  //METHODS

  public void startCar() {
    this.isRunning = true;
    this.hasLowBeam = true;
    this.hasLights = true;
    this.hasTailLights = true;
  }

  public void stopCar() {
    this.isRunning = false;
    turnOffLights();
  }

  public void turnOnLights() {
    this.hasLights = true;
    this.hasLowBeam = true;
    this.hasTailLights = true;
  }

  public void turnOffLights() {
    this.hasLights = false;
    this.hasHighBeam = false;
    this.hasLowBeam = false;
    this.hasTailLights = false;
  }

  public void setHighBeam() {
    this.hasHighBeam = true;
    this.hasLights = true;
    this.hasLowBeam = false;
  }

  public void setLowBeam() {
    this.hasLowBeam = true;
    this.hasLights = true;
    this.hasHighBeam = false;
  }

  public void useHazardLights() {
    this.hazardLightsOn = true;
  }

  public void stopUsingHazardLights() {
    this.hazardLightsOn = false;
  }

  public void accelerate() {
    if (isRunning && gear.equals("drive")) {
      consumeBattery();
      if (currentSpeed + 10 <= 180) {
        currentSpeed += 10;
      }
      gasState = 1;
    } else if(isRunning && gear.equals("reverse")) {
      consumeBattery();
      if (currentSpeed - 10 >= -50) {
        currentSpeed -= 10;
      }
      gasState = 1;
    } else {
      gasState = 0;
    }

  }

  public void brake() {
    if (isRunning) {
      if (gear.equals("drive")) {
        if (currentSpeed - 10 >= 0) {
          currentSpeed -= 10;
        } else {
          currentSpeed = 0;
        }
      } else if (gear.equals("reverse")) {
        if (currentSpeed + 10 <= 0) {
          currentSpeed += 10;
        } else {
          currentSpeed = 0;
        }
      }
      gasState = -1;
      brakeLightOn = true;
    }
  }

  public void setGear(String newGear) {
    if (isRunning && currentSpeed == 0) {
      if (newGear.equals("drive") || newGear.equals("reverse")) {
        gear = newGear;
      }
    }
  }

  public void consumeBattery() {
    if (isRunning) {
      batteryLevel -= 5;
      if (batteryLevel < 0) {
        batteryLevel = 0;
      }
    }
  }

  public void releaseGasAndBrake() {
    gasState = 0;
  }

}

