#!/usr/bin/env bash

# 从builder把z copy到每一台机器上.



a=("work@bxv-bosssearchacserver-01"
"work@bxv-bosssearchacserver-02"
"work@bxv-bosssearchbuilder-01"
"work@bxv-bosssearchfs-01"
"work@bxv-bosssearchfs-02"
"work@bxv-bosssearchfs-03"
"work@bxv-bosssearchfs-04"
"work@bxv-bosssearchgeekcommon-01"
"work@bxv-bosssearchgeekcommon-02"
"work@bxv-bosssearchjob-01"
"work@bxv-bosssearchjob-02"
"work@bxv-bosssearchjob-03"
"work@bxv-bosssearchjob-04"
"work@bxv-bosssearchjob-05"
"work@bxv-bosssearchlogparse-01"
"work@bxv-bosssearchlogparse-02"
"work@bxv-bosssearchpush-01"
"work@bxv-bosssearchrcf4b-01"
"work@bxv-bosssearchrcf4b-02"
"work@bxv-bosssearchrouter-01"
"work@bxv-bosssearchrouter-02"
"work@bxv-bosssearchrouter-03"
"work@bxv-bosssearchtagparse-01"
"work@bxv-bosssearchzpfinder-01"
"work@bxv-bosssearchzpresume-01"
"work@bxv-bosssearchzpresume-02"
"work@bxv-bosssearchzpresume-03"
"work@bxv-bosssearchmisserver-01"
"work@bxv-bosssearchmisserver-02"
"work@bxv-bosssearchmisserver-03"
)

# 在任意一台有z的机器上,执行 copy_z $server ~/bin/z
copy_z(){
    local server=$1
    local dir=$2
    ssh -p 13122 -t -t ${server} "mkdir -p ~/bin"
    scp -P 13122 -r ${dir} ${server}:/home/work/bin
    ssh -p 13122 -t -t ${server} "chmod 700 ~/bin/z"
    ssh -p 13122 -t -t ${server} "echo -e '\n#z\nif [ -f ~/bin/z ]; then\n    . ~/bin/z\nfi\n' >> ~/.bashrc"
    ssh -p 13122 -t -t ${server} "source ~/.bashrc"
}

for VAR in ${a[@]} ; do
    echo ${VAR}
    #copy_z ${VAR} ~/bin/z
done

