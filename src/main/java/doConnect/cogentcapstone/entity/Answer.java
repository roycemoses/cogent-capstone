package doConnect.cogentcapstone.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "answer_table")
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description_answer;
	private String image_src;
	private String status;
	private String datetime;
	
	@ManyToOne
        @JoinColumn(name="question_id")
        //@ToString.Exclude
	private Question question;
	
	// @OneToOne
	private String approved_by;
        
	// @OneToOne
	private String created_by;

    public Answer(String description_answer, String image_src, String status, String datetime, Question question, String approved_by, String created_by) {
        this.description_answer = description_answer;
        this.image_src = image_src;
        this.status = status;
        this.datetime = datetime;
        this.question = question;
        this.approved_by = approved_by;
        this.created_by = created_by;
    }
        
        
}
