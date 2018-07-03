package com.project.yasar.onduty.onduty.domain;

public enum TaskPriority {
    high {
        @Override
        public String toString() {
            return "Yüksek";
        }
    }, middle {
        @Override
        public String toString() {
            return "Orta";
        }
    }, low {
        @Override
        public String toString() {
            return "Düşük";
        }
    };


}
