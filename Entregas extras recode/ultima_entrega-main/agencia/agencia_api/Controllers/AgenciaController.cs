using agencia_api.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Http.HttpResults;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace agencia_api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AgenciaController : ControllerBase
    {

        private readonly AgenciaDbContext? _context;

        public AgenciaController(AgenciaDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IEnumerable<Passagem> GetPassagems()
        {
            return _context.Passages;
        }

        [HttpGet("{id}")]
        public IActionResult GetPassagemById(int id)
        {
            Passagem passagem = _context.Passages.SingleOrDefault( m => m.PASSAGEM_ID == id);
            if(passagem == null)
            {
                return NotFound();
            }
            
            return new ObjectResult(passagem);
        }

        [HttpPost]
        public IActionResult CriarPassagem([FromBody]Passagem passagem)
        {
            if(passagem == null)
            {
                return BadRequest();
            }
            _context.Passages.Add(passagem);
            _context.SaveChanges();

            return new ObjectResult(passagem);
        }

        [HttpPut]
        public IActionResult AtualizarPassagem(int id [FromBody] Passagem passagem) 
        {
            if(id != passagem.PASSAGEM_ID)
            {
                return BadRequest();
            }

            _context.Entry(passagem).State = EntityState.Modified;
            _context.SaveChanges();

            return new NoContentResult();
        }

        [HttpDelete]
        public IActionResult DeletarPassagem(int id)
        {
            var passagem = _context.Passages.SingleOrDefault(m => m.PASSAGEM_ID == id);
            if(passagem == null)
            {
                return BadRequest();
            }

            _context.Passages.Remove(passagem);
            _context.SaveChanges();

            return Ok(passagem);
        }
    }
}
