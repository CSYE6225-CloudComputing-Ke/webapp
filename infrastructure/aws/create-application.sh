#!/usr/bin/env bash


stackname=$1


vpc=$2
VpcName=$vpc"-csye6225-vpc"
ami=$3
echo "$ami"
subnet1=$vpc"-cye6225-subnet1"
echo "$subnet1"
subnet2=$vpc"-cye6225-subnet2"
echo "$subnet2"
subnet3=$vpc"-cye6225-subnet3"
echo "$subnet3"

instanceName="$stackname-csye6225-instance"
echo "$instanceName"

vpcid=$(aws ec2 describe-vpcs --filter Name=tag:Name,Values="${VpcName}" --query 'Vpcs[*].{id:VpcId}' --output text)
echo "$vpcid"

PublicSubnet1=$(aws ec2 describe-subnets --filters Name=vpc-id,Values="${vpcid}" "Name=cidrBlock,Values=10.0.0.0/24" --query 'Subnets[*].{id:SubnetId}' --output text)
echo "$PublicSubnet1"

PublicSubnet2=$(aws ec2 describe-subnets --filters Name=vpc-id,Values="${vpcid}" "Name=cidrBlock,Values=10.0.1.0/24" --query 'Subnets[*].{id:SubnetId}' --output text)
echo "$PublicSubnet2"

PublicSubnet3=$(aws ec2 describe-subnets --filters Name=vpc-id,Values="${vpcid}" "Name=cidrBlock,Values=10.0.2.0/24" --query 'Subnets[*].{id:SubnetId}' --output text)
echo "$PublicSubnet3"


User=$(aws iam get-user --user-name circleci --query User.UserId --output text)
echo "$User"

UserName="circleci"
echo $UserName


aws cloudformation create-stack --stack-name "$stackname" --template-body file://./csye6225-infra.json --capabilities CAPABILITY_NAMED_IAM --parameters ParameterKey=vpcId,ParameterValue=$vpcid ParameterKey=ImageId,ParameterValue=$ami ParameterKey=publicsubnet1,ParameterValue=$PublicSubnet1 ParameterKey=publicsubnet2,ParameterValue=$PublicSubnet2 ParameterKey=publicsubnet3,ParameterValue=$PublicSubnet3 ParameterKey=circleci,ParameterValue=$UserName

echo "Creating! Please wait until done"

aws cloudformation wait stack-create-complete --stack-name "$stackname"

echo "Done"
