def java_class(cls, sub=nil)
  out = []
  out << "package org.jytek.leaguemanager.view;"
  out << "import java.util.*;"
  out << ""
  out << "public class #{cls[0].pascal_case} {"

  

#  out << "    //"
# out << "    // Create #{cls[0].pascal_case} object from Result Set"
#  out << "    //"

#  out << "    static public #{cls[0].pascal_case} get#{cls[0].pascal_case}(ResultSet rs) throws SQLException {"
 # out << "        #{cls[0].pascal_case} #{cls[0].camel_case()} = new #{cls[0].pascal_case}();"
 # cls[1].each_with_index.each { |f,i|
    
  #  out << "        #{cls[0].camel_case}.#{f[0].camel_case} = rs.#{f[1].java_sql_get()}(#{i+1});"
  #} 
  #out << "        return #{cls[0].camel_case};"
  #out << "    }"
  #out << ""
  
  cls[1].each do |f|
    #out << "    public static String #{f[0].pascal_case} = \"#{f[0]}\";"
    
  end
  
  out << "    // Members"

  cls[1].each do |f|
    out << "    private #{f[1].java_type} #{f[0].camel_case} = #{f[1].java_type_init};"

  end
  
  
  if sub != nil
    print " < #{sub[0]}"
  end
  puts

  #initialize
  out << ""
  out << "    public #{cls[0].pascal_case}() {\n"

  out << cls[1].select{|f| f[0] !~ /fk_/}.map { |f|
    "        this.#{f[0].camel_case} = #{f[1].java_type_init};"
  } * "\n"

  out << "    "
  out << "    }" 
  out << "    public #{cls[0].pascal_case}("
  
  out << cls[1].select{|f| f[0] !~ /fk_/}.map{|f|
    "            #{f[1].java_type} #{f[0].camel_case}"} * ",\n"
  out << "    ) {"
  out << ""
  out << cls[1].select{|f| f[0] !~ /fk_/}.map { |f| "        this.#{f[0].camel_case} = #{f[0].camel_case};"} * "\n"
  out << "\n    }"

   out << ""
   out << "    // Getters/Setters"
   out << ""
   cls[1].each do |f|
     var = f[0].camel_case
     out << "    public void set#{f[0].pascal_case}(#{f[1].java_type} #{var}) {\n        this.#{var} = #{var};\n    }\n"
     out << "    public #{f[1].java_type} get#{f[0].pascal_case}() {\n        return #{var};\n    }\n"
   end
   out << "}"
   out * "\n"
 end


def java_class_dao(cls, sub=nil)

  out = []

  out << "package com.example.buzzcars.database;"

  out << "// OMSC CS6400"
  out << "// Fall Semester 2023"
  out << "// Team 14 "
  out << ""
    
  out << "import java.sql.ResultSet;"
  out << "import java.sql.SQLException;"
  out << "public class #{cls[0]}Dao {"

  

  out * "\n"
end

