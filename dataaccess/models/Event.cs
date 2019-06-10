using System;
using Amazon;
using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.DataModel;

[DynamoDBTable("events", LowerCamelCaseProperties=true)]
public class Event
{

    [DynamoDBHashKey]
    public int Id { get; set; }
}