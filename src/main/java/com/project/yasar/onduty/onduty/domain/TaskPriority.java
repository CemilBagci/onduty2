package com.project.yasar.onduty.onduty.domain;

public enum TaskPriority {
    high {
        @Override
        public String toString() {
            return "High";
        }
    }, middle {
        @Override
        public String toString() {
            return "Middle";
        }
    }, low {
        @Override
        public String toString() {
            return "Low";
        }
    };


}
