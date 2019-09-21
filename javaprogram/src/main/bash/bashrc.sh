#!/usr/bin/env bash














init(){
    local server=$1
    local dir=$2
    ssh -p 13122 -t -t ${server} "mkdir ${dir}"
    ssh -p 13122 -t -t ${server} "ln -s ${dir} /service"
}

copyDir(){
    local server=$1
    local dir=$2
    local target=$3
    scp -P 13122 -r  ${dir} ${server}:${target}
}

init 172.21.40.123 /data/search/kz-job
init 172.21.40.123 /data/search/tp-job

init 172.21.40.80 /data/search/kz-job
init 172.21.40.80 /data/search/tp-job

# copy conf
copyDir 172.21.40.123 /data/search/conf /data/search
copyDir 172.21.40.80 /data/search/conf /data/search


# kz
copyDir 172.21.40.123 kz_index /data/search/kz-job
copyDir 172.21.40.80 kz_index /data/search/kz-job

copyDir 172.21.40.123 kz_site_map /data/search/kz-job
copyDir 172.21.40.80 kz_site_map /data/search/kz-job

copyDir 172.21.40.123 run /data/search/kz-job
copyDir 172.21.40.80 run /data/search/kz-job

copyDir 172.21.40.123 zp-search2-0.1-jar-with-dependencies.jar /data/search/kz-job
copyDir 172.21.40.80 zp-search2-0.1-jar-with-dependencies.jar /data/search/kz-job

copyDir 172.21.40.123 uniq_brand_name /data/search/kz-job
copyDir 172.21.40.80 uniq_brand_name /data/search/kz-job

# tp

copyDir 172.21.40.123 tc_data /data/search/tp-job
copyDir 172.21.40.80 tc_data /data/search/tp-job

copyDir 172.21.40.123 site-map /data/search/tp-job
copyDir 172.21.40.80 site-map /data/search/tp-job

copyDir 172.21.40.123 run /data/search/tp-job
copyDir 172.21.40.80 run /data/search/tp-job

copyDir 172.21.40.123 zp-search2-0.1-jar-with-dependencies.jar /data/search/tp-job
copyDir 172.21.40.80 zp-search2-0.1-jar-with-dependencies.jar /data/search/tp-job













start_server(){
    local server=$1
    local dir=$2
    ssh -p 13122 -t -t ${server} "/command/svc -u ${dir}"
}

stop_server(){
    local server=$1
    local dir=$2
    ssh -p 13122 -t -t ${server} "/command/svc -d ${dir}"
}

restart_server(){
    local server=$1
    local dir=$2
    ssh -p 13122 -t -t ${server} "/command/svc -d ${dir} && /command/svc -u ${dir}"
}


copyDir 172.21.40.36 enterprise_data /data/search/enterprise
copyDir 172.21.40.36 run /data/search/enterprise
copyDir 172.21.40.36 zp-search2-0.1-jar-with-dependencies.jar /data/search/enterprise





