# Particle Collision Simulation

This repository contains a standalone 2D particle collision physics simulation written in Java. It allows you to simulate multiple circular particles bouncing off boundaries and colliding elastically with one another in real-time. It includes a basic GUI for configuring starting parameters such as velocity, mass, and radius of particles.

## Contents
The source code is located in the `src/` directory:
- `Particle.java`: Represents moving particles, handling collisions and movement updates.
- `Line.java`: Represents stationary boundary lines which particles can bounce off.
- `Sim.java`: The main Swing application that provides a settings configuration window and renders the main physics loop.

## Physics Engine & Logic

The simulation relies on a custom discrete-time physics engine to update particle states and handle collisions.

### Elastic Collisions
Particle-to-particle interactions are modeled as 2D elastic collisions. When the distance between the centers of two particles becomes less than the sum of their radii, a collision event is resolved:
1. Velocity vectors are converted into polar coordinates (magnitude and direction angle).
2. The contact angle between the two particles is calculated.
3. Velocities are rotated into a 1D coordinate system aligned with the contact angle.
4. The 1D elastic collision equations (conserving momentum and kinetic energy based on particle masses) are applied to determine the post-collision velocities.
5. Velocities are rotated back to the standard 2D Cartesian coordinate system.

### Boundary Reflections
Boundary constraints are handled in two ways:
- **Axis-Aligned Walls:** The bounding box of the simulation window reverses the corresponding velocity component ($v_x$ or $v_y$) upon contact.
- **Arbitrary Line Segments:** The simulation calculates the shortest distance from a particle's center to a line segment using vector projection (dot product). If the particle overlaps with the line segment, the collision is resolved by treating the line as a stationary object of near-infinite mass, reflecting the particle's velocity across the line's normal vector.

### Simulation Loop
The time evolution of the system is driven by a `javax.swing.Timer` ticking at approximately 55 frames per second (18 ms intervals). During each tick, the main physics loop:
1. Checks for boundary collisions.
2. Iterates through all pairs of particles to detect and resolve elastic collisions.
3. Iterates through all static line segments to resolve boundary deflections.
4. Integrates the velocity to update the position of each particle.
5. Triggers a UI repaint to render the updated state to the screen.

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
