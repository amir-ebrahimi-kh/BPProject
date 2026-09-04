# Particle Collision Simulation

This repository contains a standalone 2D particle collision physics simulation written in Java. It allows you to simulate multiple circular particles bouncing off boundaries and colliding elastically with one another in real-time. It includes a basic GUI for configuring starting parameters such as velocity, mass, and radius of particles.

## Contents
The source code is located in the `src/` directory:
- `Particle.java`: Represents moving particles, handling collisions and movement updates.
- `Line.java`: Represents stationary boundary lines which particles can bounce off.
- `Sim.java`: The main Swing application that provides a settings configuration window and renders the main physics loop.

## How to Compile and Run

The project has no external dependencies and uses basic standard Java tooling. It uses `javac` for compilation and `java` to run.

1. **Compile the code:**

From the root directory, compile the Java files into a `bin/` output directory:

```bash
mkdir -p bin
javac -d bin src/*.java
```

2. **Run the simulation:**

Execute the main `Sim` class:

```bash
java -cp bin Sim
```

## Usage

When running the application, a settings window will appear. You can:
- Change the number of particles and their settings (velocity, mass, size, position).
- Use the **"All Default"** checkbox for a quick pre-configured setup.
- Press **"Start The Simulation"** to launch the physics view.
