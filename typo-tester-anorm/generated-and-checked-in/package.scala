/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */


package object adventureworks {
  implicit val StringArray: anorm.ToStatement[scala.Array[java.lang.String]] with anorm.ParameterMetaData[scala.Array[java.lang.String]] = new anorm.ToStatement[scala.Array[java.lang.String]] with anorm.ParameterMetaData[scala.Array[java.lang.String]] {
    override def sqlType: java.lang.String = "_varchar"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[java.lang.String]): scala.Unit =
      ps.setArray(index, ps.getConnection.createArrayOf("varchar", v.map(v => v: scala.AnyRef)))
  }
  
  implicit val FloatArray: anorm.ToStatement[scala.Array[scala.Float]] with anorm.ParameterMetaData[scala.Array[scala.Float]] = new anorm.ToStatement[scala.Array[scala.Float]] with anorm.ParameterMetaData[scala.Array[scala.Float]] {
    override def sqlType: java.lang.String = "_float4"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Float]): scala.Unit =
      ps.setArray(index, ps.getConnection.createArrayOf("float4", v.map(v => v: java.lang.Float)))
  }
  
  implicit val ShortArray: anorm.ToStatement[scala.Array[scala.Short]] with anorm.ParameterMetaData[scala.Array[scala.Short]] = new anorm.ToStatement[scala.Array[scala.Short]] with anorm.ParameterMetaData[scala.Array[scala.Short]] {
    override def sqlType: java.lang.String = "_int2"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Short]): scala.Unit =
      ps.setArray(index, ps.getConnection.createArrayOf("int2", v.map(v => v: java.lang.Short)))
  }
  
  implicit val IntArray: anorm.ToStatement[scala.Array[scala.Int]] with anorm.ParameterMetaData[scala.Array[scala.Int]] = new anorm.ToStatement[scala.Array[scala.Int]] with anorm.ParameterMetaData[scala.Array[scala.Int]] {
    override def sqlType: java.lang.String = "_int4"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Int]): scala.Unit =
      ps.setArray(index, ps.getConnection.createArrayOf("int4", v.map(v => v: java.lang.Integer)))
  }
  
  implicit val LongArray: anorm.ToStatement[scala.Array[scala.Long]] with anorm.ParameterMetaData[scala.Array[scala.Long]] = new anorm.ToStatement[scala.Array[scala.Long]] with anorm.ParameterMetaData[scala.Array[scala.Long]] {
    override def sqlType: java.lang.String = "_int8"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Long]): scala.Unit =
      ps.setArray(index, ps.getConnection.createArrayOf("int8", v.map(v => v: java.lang.Long)))
  }
  
  implicit val BooleanArray: anorm.ToStatement[scala.Array[scala.Boolean]] with anorm.ParameterMetaData[scala.Array[scala.Boolean]] = new anorm.ToStatement[scala.Array[scala.Boolean]] with anorm.ParameterMetaData[scala.Array[scala.Boolean]] {
    override def sqlType: java.lang.String = "_bool"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Boolean]): scala.Unit =
      ps.setArray(index, ps.getConnection.createArrayOf("bool", v.map(v => v: java.lang.Boolean)))
  }
  
  implicit val DoubleArray: anorm.ToStatement[scala.Array[scala.Double]] with anorm.ParameterMetaData[scala.Array[scala.Double]] = new anorm.ToStatement[scala.Array[scala.Double]] with anorm.ParameterMetaData[scala.Array[scala.Double]] {
    override def sqlType: java.lang.String = "_float8"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Double]): scala.Unit =
      ps.setArray(index, ps.getConnection.createArrayOf("float8", v.map(v => v: java.lang.Double)))
  }
  
  implicit val UUIDArray: anorm.ToStatement[scala.Array[java.util.UUID]] with anorm.ParameterMetaData[scala.Array[java.util.UUID]] = new anorm.ToStatement[scala.Array[java.util.UUID]] with anorm.ParameterMetaData[scala.Array[java.util.UUID]] {
    override def sqlType: java.lang.String = "_uuid"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[java.util.UUID]): scala.Unit =
      ps.setArray(index, ps.getConnection.createArrayOf("uuid", v.map(v => v: scala.AnyRef)))
  }
  
  implicit val BigDecimalArray: anorm.ToStatement[scala.Array[scala.math.BigDecimal]] with anorm.ParameterMetaData[scala.Array[scala.math.BigDecimal]] = new anorm.ToStatement[scala.Array[scala.math.BigDecimal]] with anorm.ParameterMetaData[scala.Array[scala.math.BigDecimal]] {
    override def sqlType: java.lang.String = "_decimal"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.math.BigDecimal]): scala.Unit =
      ps.setArray(index, ps.getConnection.createArrayOf("decimal", v.map(v => v: scala.AnyRef)))
  }
  
  implicit val localTimeDb: anorm.ToStatement[java.time.LocalTime] with anorm.ParameterMetaData[java.time.LocalTime] with anorm.Column[java.time.LocalTime] = new anorm.ToStatement[java.time.LocalTime] with anorm.ParameterMetaData[java.time.LocalTime] with anorm.Column[java.time.LocalTime] {
    override def sqlType: java.lang.String = "time"
    override def jdbcType: scala.Int = java.sql.Types.TIME
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: java.time.LocalTime): scala.Unit =
      s.setObject(index, new java.sql.Time(v.toNanoOfDay / 1000000))
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, java.time.LocalTime] =
      v1 match {
        case v: java.sql.Time => scala.Right(v.toLocalTime)
        case other => scala.Left(anorm.TypeDoesNotMatch(s"Expected instance of java.sql.Time, got ${other.getClass.getName}"))
      }
  }

}
