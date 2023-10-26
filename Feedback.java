package org.example;
import java.util.Date;

public class Feedback {
    private String visitorName;
    private String feedbackContent;
    private Date feedbackDate;

    public Feedback(String visitorName, String feedbackContent) {
        this.visitorName = visitorName;
        this.feedbackContent = feedbackContent;
        this.feedbackDate = new Date();
    }

    public String getVisitorName() {
        return visitorName;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }
    @Override
    public String toString() {
        return "Visitor: " + visitorName + "\nFeedback: " + feedbackContent + "\nDate: " + feedbackDate;
    }
}
