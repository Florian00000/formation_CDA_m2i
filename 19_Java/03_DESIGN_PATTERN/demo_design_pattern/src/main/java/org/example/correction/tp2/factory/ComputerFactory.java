package org.example.correction.tp2.factory;

import org.example.correction.tp2.entity.Computer;
import org.example.correction.tp2.entity.Processor;
import org.example.correction.tp2.entity.RAM;

public class ComputerFactory extends ProductFactory {
    private Processor processor;
    private RAM ram;

    public void withProcessor(Processor processor) {
        this.processor = processor;
    }

    public void withRAM(RAM ram) {
        this.ram = ram;
    }

    public Computer createComputer() {
        return Computer.builder().ram(ram).processor(processor).build();
    }
}
