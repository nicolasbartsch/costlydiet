#!/bin/bash

user=$1

set_git_user() {
  git config user.name "$1"
  git config user.email "$1@email"
  echo "Switched user to:"
  git config user.name
  git config user.email
}

if [[ $user == "alice" ]]; then
  set_git_user "alice"  
elif [[ $user == "bob" ]]; then
  set_git_user "bob"
elif [[ $user == "mark" ]]; then
  set_git_user "mark"
elif [[ $user == "david" ]]; then
  set_git_user "david"
elif [[ $user == "sarah" ]]; then
  set_git_user "sarah"
else
  echo "The user you provided does not exist"
fi


