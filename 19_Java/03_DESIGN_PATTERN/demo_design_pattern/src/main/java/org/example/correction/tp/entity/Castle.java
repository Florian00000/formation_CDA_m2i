package org.example.correction.tp.entity;


public class Castle extends Building {

    private int size;
    private String style;
    private String name;

    private Castle(CastleBuilder builder) {
        size = builder.size;
        style = builder.style;
        name = builder.name;
    }
    public static class CastleBuilder extends AbstractBuildingBuilder {
        private int size;
        private String style;
        private String name;

        public CastleBuilder size(int size) {
            this.size = size;
            return this;
        }

        public CastleBuilder style(String style) {
            this.style = style;
            return this;
        }

        public CastleBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Castle build() {
            return new Castle(this);
        }
    }
}
