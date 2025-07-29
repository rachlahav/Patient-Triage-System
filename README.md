This project implements an automated emergency room (ER) triage system that dynamically assigns patients to doctors based on medical priority and available resources. It simulates real-world ER operations by modeling how incoming patients are processed and prioritized depending on the set rules.

This project simulates integration with the Pega Platform by implementing a `PegaWorkflowSimulator` class
that models patient prioritization using PegaRULES-style dynamic case management rules.

The Java backend handles core triage logic, while PegaWorkflowSimulator represents
the low-code automation and UI dashboard components typical of Pega applications.
