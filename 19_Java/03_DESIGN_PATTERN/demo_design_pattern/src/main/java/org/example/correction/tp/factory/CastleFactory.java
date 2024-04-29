package org.example.correction.tp.factory;

import org.example.correction.tp.entity.AbstractBuildingBuilder;
import org.example.correction.tp.entity.Building;

public class CastleFactory extends BuildingFactory {
    @Override
    public Building createBuilding(AbstractBuildingBuilder castleBuilder) {
        return castleBuilder.build();
    }
}
