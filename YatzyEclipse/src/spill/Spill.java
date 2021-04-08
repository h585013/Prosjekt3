package no.hvl.dat109.spill;
@Entity
@Table(shema="public", name="spiller")
public class Spill {
@Id
@GeneratedValue
private Long id;
private Stirng spillNavn;

}
