using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Grpc.Core;
using Schema;
using Google.Protobuf;
using Google.Protobuf.WellKnownTypes;


namespace server
{
    public class Service : ReservationService.ReservationServiceBase
    {
        public override Task<TransactionResponse> Reserve(TransactionRequest request, ServerCallContext context)
        {
            return Task.FromResult(new TransactionResponse
            {
                Id = request.Id,
                Date = Timestamp.FromDateTime(DateTime.UtcNow),
                Message = $"{DateTime.Now.ToString("G")} - {Guid.NewGuid().ToString()}"
            });
        }
    }
}
