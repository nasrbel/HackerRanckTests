//package solutions;
//
//
//        import java.io.Serializable;
//        import java.time.LocalDate;
//
//        import org.apache.spark.sql.types.DataTypes;
//        import org.apache.spark.sql.types.StructField;
//        import org.apache.spark.sql.types.StructType;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class EntityMySQL implements Serializable {
//
//    @JsonFormat(pattern="yyyy-MM-dd")
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    private LocalDate date;
//
//    private float value;
//
//    private String id;
//
//    private String title;
//
//    private static StructType structType = DataTypes.createStructType(new StructField[] {
//
//            DataTypes.createStructField("date", DataTypes.DateType, false),  // this line throws Exception
//            DataTypes.createStructField("value", DataTypes.FloatType, false),
//            DataTypes.createStructField("id", DataTypes.StringType, false),
//            DataTypes.createStructField("title", DataTypes.StringType, false)
//    });