#!/usr/bin/env bash

function usage {
  printf "%s [problem#]\n" $(basename $0)
  printf "%s [from] [to]\n" $(basename $0)
  printf "\nDESCRIPTION\n\n"
  printf "problem#\t run one particular problem #\n"
  printf "from, to\t run a range of problems\n"
  exit 1
} >&2

function filename {
  number=$(printf "%02d" $1)
  echo project.euler.problems.Problem_${number}
}

[ $# -eq 0 -o $# -gt 2 ] && usage

classpath=lib/groovy-all-2.3.4.jar:gen/classes/
from=$1
to=${2:-$1}

for i in $(seq $from $to) ; do
  printf "Problem $i: "
  java -cp ${classpath} $(filename $i)
done
