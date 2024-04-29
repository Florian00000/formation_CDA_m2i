package org.example.correction.tp.factory;

import org.example.correction.tp.entity.AbstractBuildingBuilder;
import org.example.correction.tp.entity.Building;

public abstract class BuildingFactory {

    public abstract Building createBuilding(AbstractBuildingBuilder builder);
}
