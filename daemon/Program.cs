using System;
using System.Threading.Tasks;
using Grpc.Core;
using Google.Protobuf;
using Google.Protobuf.WellKnownTypes;
using Schema;
namespace daemon
{
    class Program
    {
        static async Task Main(string[] args)
        {
            // The port number(50051) must match the port of the gRPC server.
            var channel = new Channel("localhost:50051",
                                       ChannelCredentials.Insecure);
            var client = new ReservationService.ReservationServiceClient(channel);
            var id = Guid.NewGuid();
            var request = new TransactionRequest{
                Date = Timestamp.FromDateTime(DateTime.UtcNow),
                Id = Google.Protobuf.ByteString.CopyFrom(id.ToByteArray()),
            };
            var response = await client.ReserveAsync(request);
            var responseId = new Guid(response.Id.ToByteArray());
            Console.WriteLine($"req:{id} resp:{responseId}:" + response.Message);
            await channel.ShutdownAsync();
            Console.WriteLine("Press any key to exit...");
            Console.ReadKey();
        }
    }
}
