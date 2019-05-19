task :default => :ps


desc "ps"
task :ps do
     sh 'git ps origin master'
     sh 'git ps blog_origin master'
end


desc "deploy"
task :d, :msg do |t, args|
      mm = args[:msg]
      sh "git add ."
      sh "git ci -am #{mm}"
      sh 'git ps origin master'
end


