package doConnect.cogentcapstone.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question_table")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description_question;
	private String image_src;
	private String datetime;
	private String status;
	private String topic;
	private String title;
	//mappedBy = "question", fetch=FetchType.EAGER, 
        
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "question")
	@JsonIgnore
//        @JoinColumn(name = "question_id",referencedColumnName = "question_id")
        @ToString.Exclude
	private List<Answer> answers;
        
	/*
        //setter method
        public void setAnswers(Answer answer) {
            this.answers.add(answer);
	}
        
        //getter
        public List<Answer> getAnswers() {
            return answers;
	}
        */
        
	//@OneToOne
	private String qcreated_by;
	
	//@OneToOne
	private String qapproved_by;

    public Question(String description_question, String image_src, String status, String topic, String title, List<Answer> answers, String qcreated_by, String qapproved_by) {
        this.description_question = description_question;
        this.image_src = image_src;
        this.status = status;
        this.topic = topic;
        this.title = title;
        this.answers = answers;
        this.qcreated_by = qcreated_by;
        this.qapproved_by = qapproved_by;
    }
        
        
	
}
