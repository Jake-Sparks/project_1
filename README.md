# Smart Renewable City Energy Simulation
## Overview

#### This project is a Java-based renewable energy simulation that models a simplified smart city electricity system powered by renewable sources.

#### The system simulates:
- Renewable energy production from solar farms and wind farms.
- Energy storage systems (battery, pumped hydro, hydrogen).
- Daily weather variability.
- City electricity demand.
- Energy balancing between generation, storage, and demand.
- The simulation allows users to build a virtual renewable-powered city and observe how different configurations perform over time.

### Features

The simulation models several real-world energy system concepts:
- Variable renewable energy generation.
- Energy storage systems.
- Weather-dependent generation.
- City electricity demand.
- Energy shortages (blackouts).
- Energy surplus stored in batteries or other systems.
- Users interact with the simulation through a command-line interface.

## How to Run

1. Compile the project

From the project folder:
javac *.java

2. Run the simulation
java SimulationRunner

### Simulation Menu
The program provides the following menu:

SMART RENEWABLE CITY SIMULATION

1. Create City
2. Add Energy Source
3. Add Storage System
4. View System Details
5. Run Simulation (Daily Report)
6. Run Simulation (Summary Only)
7. Exit

## Step-by-Step Usage

#### 1. Create a City

The city requires two parameters:
Population
Average daily electricity consumption (kWh per person)

Example:
Population: 100000
Consumption: 25

This means each person uses 25 kWh/day.
Average household electricity use in developed countries is roughly 20–30 kWh per day depending on household size.

The simulation converts this to MWh internally.

#### 2. Add Energy Sources

You can add multiple energy sources.

#### Solar Farm

Inputs:

- Capacity (MW)
- Efficiency (0–1)

Example:

- Capacity: 200
- Efficiency: 0.9

Large utility-scale solar farms typically exceed 50 MW, with many modern installations averaging around 70 MW or more.
Solar capacity factors typically range around 20–25% depending on location.

#### Wind Farm

Inputs:

- Number of turbines
- Turbine capacity (MW)
- Efficiency
- Location (land/offshore)

**Modern wind turbines commonly have:**

- 2–4 MW capacity onshore
- 8–12 MW offshore

**Typical wind turbine capacity factors:**

- Onshore: 23–44%
- Offshore: higher due to stronger winds (50% or so)

#### 3. Add Energy Storage

The simulation supports:

- Battery storage
- Pumped hydro storage
- Hydrogen storage

----------------------------

#### Example inputs:

Battery storage capacity: 2000 MWh

Characterisitcs of the storage systems (based on real-world systems):

- Storage Type----------Efficiency-----------Typical Use
- Battery----------------95%--------------------short-term storage
- Pumped hydro-------80%--------------------large-scale grid storage
- Hydrogen------------55%--------------------long-term seasonal storage


Users specify the number of days to simulate:
- Enter number of days: 30

Each day the simulation generates random weather conditions:

- Wind speed
- Solar intensity
- Sun hours

These affect renewable generation.

The system then:
- Generates renewable energy
- Calculates city demand
- Stores excess energy
- Uses storage when demand exceeds supply
- Reports blackouts if demand cannot be met

## Output

Example daily output:

DAY 4

Weather Report

- Wind Speed: 9.4 m/s
- Sun Intensity: 0.71
- Sun Hours: 5.2

Energy Report

- Production: 2450 MWh
- Demand: 2300 MWh

Storage Status

- Battery Storage: 1500 / 2000 MWh
- Pumped Hydro Storage: 600 / 1000 MWh
- Hydrogen Storage: 400 / 2000 MWh

-------------------------

Recommended Test Scenarios:

**Small City**

- Population: 10,000
- Consumption: 20
- Solar farm: 100 MW
- Wind farm: 10 turbines (3 MW)
- Battery: 500 MWh

**Expected behavior:**

- Few or no blackouts
- occasional storage usage

---------------------------

**Medium City**

- Population: 100,000
- Consumption: 25
- Solar farms: 2 × 300 MW
- Wind farm: 30 turbines (4 MW)
- Battery: 2000 MWh
- Hydrogen storage: 5000 MWh

**Expected behavior:**

- storage frequently used
- occasional shortages depending on weather

-----------------------------

**Stress Test**

- Population: 500,000
- Consumption: 30
- Solar farm: 100 MW
- Wind farm: 10 turbines (3 MW)

Expected behavior:

- frequent blackouts
- storage depleted quickly

---------------------------------

## Scientific Context

Electricity consumption varies significantly by country.

Developed countries typically consume 4,000–6,000 kWh per person per year.

Wind turbines today commonly produce several million kWh annually and can power around 1,500 homes per turbine.

Renewable energy systems rely heavily on capacity factors (actual output vs theoretical maximum), which explains why renewable plants rarely produce their rated output continuously.

## Limitations of the Simulation

This model simplifies real energy systems.

Not included:

- electrical grid transmission limits
- seasonal weather patterns
- industrial energy demand
- economic costs
- grid frequency balancing

The goal is to demonstrate core renewable energy concepts, not fully model national power systems.

However, this is a developing on-going project thus these are areas of inclusion to be heavily considered, especially in current world circumstances.

## Learning Outcomes

This simulation demonstrates:

- Object-oriented programming in Java
- Energy system modelling
- Renewable energy variability
- Energy storage management
- Input validation and simulation design

## Possible Extensions

**Future improvements could include:**

- seasonal weather patterns
- electricity pricing
- carbon emissions tracking
- demand response
- electric vehicle charging demand
