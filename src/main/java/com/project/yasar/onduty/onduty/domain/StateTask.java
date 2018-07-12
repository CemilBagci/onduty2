package com.project.yasar.onduty.onduty.domain;

public enum StateTask {
	completed {
        @Override
        public String toString() {
            return "Completed";
        }
    }, notcompleted {
        @Override
        public String toString() {
            return "NotCompleted";
        }
    };

}
