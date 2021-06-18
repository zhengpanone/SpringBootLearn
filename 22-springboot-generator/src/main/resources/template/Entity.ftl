package ${package}.entity;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="${tableName}")
public class ${className} implements Serializable {

}