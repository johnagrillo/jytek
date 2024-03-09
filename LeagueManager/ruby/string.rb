class String

  "hello_world".split('_').collect(&:capitalize).join #=> "HelloWorld"

  
  def camel_case
    out = split(' ').collect(&:capitalize).join #=> "HelloWorld"
    out[0].downcase + out[1..-1]
  end

  def pascal_case
    split(' ').collect(&:capitalize).join #=> "HelloWorld"
    
  end
  
  def under_case_capitalize
    under_case.map {|w| w.capitalize}.join("")
  end

  def under_case
    downcase.split(" ").join("_")
  end

  def dash_case
    downcase.split(" ").join("-")
  end

  def snake_case
    self.gsub(" ", "_");
  end
  
  def java_type
    name = self
    if self =~ /Var/
      name = "String"
    elsif self =~ /Decimal/
      name = "BigDecimal"
    elsif self =~ /Date/
      name = "java.util.Date"
    end
    name
  end
  
  def java_type_init
    name = self
    if self =~ /Var/
      name = "\"\""
    elsif self =~ /Decimal/
      name = "new BigDecimal(0)"
    elsif self =~ /Date/
      name = "new Date()"
    elsif self =~ /Integer/
      name = "0"
    elsif self =~ /Short/
      name = "0"
    elsif self =~ /String/
      name = "\"\"";
    end
    
    name
  end
  
  def java_sql_get
    name = self
    if self =~ /Var/
      return "getString"
    elsif self =~ /Decimal/
      return "getBigDecimal"
    elsif self =~ /Float/
      return "getBigDecimal"
    elsif self =~ /Integer/
      return "getInt"
    end
    "get" + name 
  end

  def java_sql_default
    name = self
    if self =~ /Var/
      return "\"\""
    elsif self =~ /Decimal/
      return "BigDecimal.valueOf(0.0)"
    elsif self =~ /Float/
      return "0.0"
    elsif self =~ /Integer/
      return "0"
    end
    "get" + name 
  end


  
end



class Integer
  def to_sql_value
    self
  end
end

class String
  def to_sql_value
    "'" + self + "'"
  end
end

class NilClass
  def to_sql_value
    "NULL"
  end
end

