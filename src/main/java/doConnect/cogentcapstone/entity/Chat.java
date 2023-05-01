package doConnect.cogentcapstone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat_table")
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
        
//        @ManyToOne
//        @JoinColumn(name="from_user") //the underscore seems to break this.
	private String fromUser;
        
//        @ManyToOne
//        @JoinColumn(name="to_user")
	private String toUser;
        
        
	private String message;
	private String datetime;
}

