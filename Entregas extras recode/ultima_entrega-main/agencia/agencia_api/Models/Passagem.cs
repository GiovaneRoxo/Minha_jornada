using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace agencia_api.Models
{
    [Table("passagem")]
    public class Passagem
    {
        [Key]
        public int PASSAGEM_ID { get; set; }
        public string? Destino { get; set; }
        public string? Origem { get; set; }
    }
}
