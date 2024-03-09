def ruby_class(cls, sub=nil)

  print "class #{cls[0]}"
  if sub != nil
    print " < #{sub[0]}"
  end
  puts

  cls[1].each do |f|
    print "  attr_accessor :#{f[0]}\n"
  end

  #initilisre

  print "  def initialize()\n"
  
  cls[1].each do |f|
    print "      @#{f[0]} = nil\n"
  end
  puts "  end"  
  puts "end"
end


