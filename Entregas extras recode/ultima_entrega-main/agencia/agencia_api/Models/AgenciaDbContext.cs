using Microsoft.EntityFrameworkCore;

namespace agencia_api.Models
{
    public class AgenciaDbContext : DbContext
    {
        public AgenciaDbContext(DbContextOptions<AgenciaDbContext> options):
            base(options)
        { }

        public DbSet<Passagem> Passages { get; set; }
    }
}
